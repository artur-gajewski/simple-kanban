(ns simple-kanban.actions
  (:require [potpuri.core :refer [map-of]]
            [simple-kanban.state :refer [id-counter
                                         in-backlog
                                         new-task-description
                                         new-task-owner]]))

(defn reset-inputs []
  (reset! new-task-description "")
  (reset! new-task-owner ""))

(defn remove-card [id current-section-cards]
  (swap! current-section-cards dissoc id))

(defn advance-card [task current-section-cards next-section-cards]
  (let [{:keys [id description owner]} (val task)]
    (remove-card id current-section-cards)
    (if-not (nil? next-section-cards)
      (swap! next-section-cards assoc id (val task)))))

(defn add-card-to-backlog [description owner]
  (let [id (swap! id-counter inc)]
    (swap! in-backlog assoc id (map-of id description owner))
    (reset-inputs)))
