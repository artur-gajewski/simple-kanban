(ns simple-kanban.actions
  (:require [simple-kanban.utils :as utils]
            [simple-kanban.state :as state]))

(defn reset-inputs []
  (reset! state/new-task-description "")
  (reset! state/new-task-owner ""))

(defn remove-card [id cards]
  (swap! cards dissoc id))

(defn advance-card [card cards destination]
  (if (nil? destination) (remove-card (utils/card-data card :id) cards))
  (let [id (utils/card-data card :id)
        task (utils/card-data card :task)
        completed (utils/card-data card :completed)
        owner (utils/card-data card :owner)]
    (swap! destination assoc id {:id id :task task :completed completed :owner owner}))
  (remove-card (utils/card-data card :id) cards))

(defn add-card-to-backlog [task owner]
  (let [id (swap!
            state/id-counter inc)]
    (swap! state/in-backlog assoc id {:id id :task task :completed false :owner owner}))
  (reset-inputs))