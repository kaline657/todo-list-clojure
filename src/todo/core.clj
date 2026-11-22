
(ns todo.core
  (:require [todo.db :as db]))

(defn -main [& args]
  (println "================================")
  (println "       TODO LIST - CLOJURE      ")
  (println "================================")

  (db/inicializar-banco)

  (println "Sistema iniciado com sucesso!"))
