
(ns todo.teste
  (:require [todo.db :as db]))

(defn -main [& args]
  (db/inicializar-banco)

  (println "\nTarefas cadastradas:")

  (doseq [tarefa (db/listar-tarefas)]
    (println tarefa)))
