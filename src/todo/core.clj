
(ns todo.core
  (:require [todo.db :as db]
            [clojure.string :as str]))

;; Exibe o menu principal
(defn mostrar-menu []
  (println "\n================================")
  (println "       TODO LIST - CLOJURE")
  (println "================================")
  (println "1 - Adicionar tarefa")
  (println "2 - Listar tarefas")
  (println "3 - Editar tarefa")
  (println "4 - Concluir/Reabrir tarefa")
  (println "5 - Excluir tarefa")
  (println "0 - Sair")
  (print "\nEscolha uma opcao: ")
  (flush))

;; Le e valida o ID informado
(defn ler-id []
  (print "Digite o ID da tarefa: ")
  (flush)
  (try
    (let [entrada (read-line)]
      (when entrada
        (Integer/parseInt (str/trim entrada))))
    (catch Exception _
      (println "ID invalido!")
      nil)))

;; Mostra as tarefas cadastradas
(defn mostrar-tarefas []
  (println "\n========== TAREFAS ==========")
  (let [tarefas (db/listar-tarefas)]
    (if (empty? tarefas)
      (println "Nenhuma tarefa cadastrada.")
      (doseq [tarefa tarefas]
        (println
          (str (:id tarefa) " - "
               (:titulo tarefa) " ["
               (if (:concluida tarefa)
                 "Concluida"
                 "Pendente")
               "]")))))
  (println "============================="))

;; Aguarda o usuario antes de voltar ao menu
(defn aguardar-enter []
  (println "\nPressione ENTER para voltar ao menu...")
  (flush)
  (read-line))

;; Executa a opcao selecionada
(defn executar-opcao [opcao]
  (case opcao

    ;; CREATE - Adicionar tarefa
    "1"
    (do
      (print "Digite o titulo da tarefa: ")
      (flush)
      (let [titulo (read-line)]
        (if (str/blank? titulo)
          (println "O titulo nao pode ser vazio!")
          (db/adicionar-tarefa (str/trim titulo)))))

    ;; READ - Listar tarefas
    "2"
    (mostrar-tarefas)

    ;; UPDATE - Editar tarefa
    "3"
    (when-let [id (ler-id)]
      (print "Digite o novo titulo: ")
      (flush)
      (let [titulo (read-line)]
        (if (str/blank? titulo)
          (println "O titulo nao pode ser vazio!")
          (db/editar-tarefa id (str/trim titulo)))))

    ;; TOGGLE - Concluir ou reabrir tarefa
    "4"
    (when-let [id (ler-id)]
      (db/alternar-conclusao id))

    ;; DELETE - Excluir tarefa
    "5"
    (when-let [id (ler-id)]
      (db/excluir-tarefa id))

    ;; Opcao invalida
    (println "Opcao invalida!")))

;; Funcao principal da aplicacao
(defn -main [& args]
  (db/inicializar-banco)
  (loop []
    (mostrar-menu)
    (let [opcao (read-line)]
      (if (or (nil? opcao) (= (str/trim opcao) "0"))
        (println "\nEncerrando o sistema. Ate logo!")
        (do
          (executar-opcao (str/trim opcao))
          (aguardar-enter)
          (recur))))))
