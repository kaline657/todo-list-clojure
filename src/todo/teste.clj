
(ns todo.teste
  (:require [todo.db :as db]))

(defn -main [& args]
  (db/inicializar-banco)

  (println "\nAlterando o status da tarefa de ID 1...")
  (db/alternar-conclusao 1)

  (println "\nTarefas apos a alteracao:")
  (doseq [tarefa (db/listar-tarefas)]
    (println tarefa)))
