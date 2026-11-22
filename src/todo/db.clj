
(ns todo.db
  (:import [java.sql DriverManager]))

(def db-url "jdbc:sqlite:todo.db")

(defn conectar []
  (DriverManager/getConnection db-url))

(defn inicializar-banco []
  (Class/forName "org.sqlite.JDBC")
  (with-open [conn (conectar)
              stmt (.createStatement conn)]
    (.execute stmt
      "CREATE TABLE IF NOT EXISTS tarefas (
         id INTEGER PRIMARY KEY AUTOINCREMENT,
         titulo TEXT NOT NULL,
         concluida INTEGER NOT NULL DEFAULT 0
       )"))
  (println "Banco de dados SQLite inicializado!"))

