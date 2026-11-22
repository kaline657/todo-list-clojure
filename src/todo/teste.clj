
(ns todo.teste
  (:require [todo.db :as db]))

(defn -main [& args]
  (db/inicializar-banco)

  (println "\nTarefas antes da exclusao:")
  (doseq [tarefa (db/listar-tarefas)]
    (println tarefa))

  (println "\nExcluindo a tarefa de ID 3...")
  (db/excluir-tarefa 3)

  (println "\nTarefas depois da exclusao:")
  (doseq [tarefa (db/listar-tarefas)]
    (println tarefa)))
