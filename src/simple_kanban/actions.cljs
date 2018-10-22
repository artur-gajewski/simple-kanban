(ns simple-kanban.actions
  (:require [simple-kanban.utils :as utils]
            [simple-kanban.state :as state]))

(defn reset-inputs []
  (reset! state/new-task-description "")
  (reset! state/new-task-owner ""))

(defn remove-card [id cards]
  (swap! cards dissoc id))

(defn advance-card [card cards destination]
  (remove-card (utils/card-data card :id) cards)
  (if-not (nil? destination)
    (let [id (utils/card-data card :id)
          description (utils/card-data card :description)
          completed (utils/card-data card :completed)
          owner (utils/card-data card :owner)]
      (swap! destination assoc id {:id id :description description :completed completed :owner owner}))))

(defn add-card-to-backlog [description owner]
  (let [id (swap!
            state/id-counter inc)]
    (swap! state/in-backlog assoc id {:id id :description description :completed false :owner owner}))
  (reset-inputs))