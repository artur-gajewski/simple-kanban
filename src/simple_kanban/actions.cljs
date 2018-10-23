(ns simple-kanban.actions
  (:require [simple-kanban.utils :refer [card-data]]
            [simple-kanban.state :refer [id-counter
                                         in-backlog
                                         new-task-description
                                         new-task-owner]]))

(defn reset-inputs []
  (reset! new-task-description "")
  (reset! new-task-owner ""))

(defn remove-card [id cards]
  (swap! cards dissoc id))

(defn advance-card [card cards destination]
  (remove-card (card-data card :id) cards)
  (if-not (nil? destination)
    (let [id (card-data card :id)
          description (card-data card :description)
          completed (card-data card :completed)
          owner (card-data card :owner)]
      (swap! destination assoc id {:id id :description description :completed completed :owner owner}))))

(defn add-card-to-backlog [description owner]
  (let [id (swap! id-counter inc)]
    (swap! in-backlog assoc id {:id id :description description :completed false :owner owner}))
  (reset-inputs))