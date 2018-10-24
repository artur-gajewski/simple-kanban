(ns simple-kanban.actions
  (:require [simple-kanban.state :refer [id-counter
                                         in-backlog
                                         new-task-description
                                         new-task-owner]]))

(defn reset-inputs []
  (reset! new-task-description "")
  (reset! new-task-owner ""))

(defn remove-card [id current-section-cards]
  (swap! current-section-cards dissoc id))

(defn advance-card [task current-section-cards next-section-cards]
  (let [{:keys [id description completed owner]} (val task)]
    (remove-card id current-section-cards)
    (if-not (nil? next-section-cards)
      (swap! next-section-cards assoc id {:id id
                                          :description description
                                          :completed completed
                                          :owner owner}))))

(defn add-card-to-backlog [description owner]
  (let [id (swap! id-counter inc)]
    (swap! in-backlog assoc id {:id id
                                :description description
                                :completed false
                                :owner owner}))
  (reset-inputs))
