
(ns todo.db
  (:import [java.sql DriverManager]))

;; Caminho do banco de dados SQLite
(def db-url "jdbc:sqlite:todo.db")

;; Abre uma conexao com o banco
(defn conectar []
  (Class/forName "org.sqlite.JDBC")
  (DriverManager/getConnection db-url))

;; Cria a tabela de tarefas, caso nao exista
(defn inicializar-banco []
  (with-open [conn (conectar)
              stmt (.createStatement conn)]
    (.execute stmt
      "CREATE TABLE IF NOT EXISTS tarefas (
         id INTEGER PRIMARY KEY AUTOINCREMENT,
         titulo TEXT NOT NULL,
         concluida INTEGER NOT NULL DEFAULT 0
       )"))
  (println "Banco de dados SQLite inicializado!"))

;; CREATE - Adicionar uma tarefa
(defn adicionar-tarefa [titulo]
  (with-open [conn (conectar)
              stmt (.prepareStatement conn
                     "INSERT INTO tarefas (titulo, concluida)
                      VALUES (?, 0)")]
    (.setString stmt 1 titulo)
    (.executeUpdate stmt)
    (println "Tarefa adicionada com sucesso!")))

;; READ - Listar todas as tarefas
(defn listar-tarefas []
  (with-open [conn (conectar)
              stmt (.createStatement conn)
              rs (.executeQuery stmt
                    "SELECT id, titulo, concluida
                     FROM tarefas
                     ORDER BY id")]
    (loop [tarefas []]
      (if (.next rs)
        (recur
          (conj tarefas
                {:id (.getInt rs "id")
                 :titulo (.getString rs "titulo")
                 :concluida (= 1 (.getInt rs "concluida"))}))
        tarefas))))
