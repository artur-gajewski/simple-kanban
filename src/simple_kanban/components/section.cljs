(ns simple-kanban.components.section
  (:require [simple-kanban.components.new-card-input :refer [new-card-input]]
            [simple-kanban.components.card-list :refer [card-list]]))

(defn section [title button-text current-section-cards next-section-cards is-backlog enable-alert]
  [:div {:class "section"}
   (let [cards-in-section (count @current-section-cards)]
     [:div {:class (if enable-alert
                     (cond
                       (< cards-in-section 4) "column-header"
                       (>= cards-in-section 4) "column-header alert")
                     "column-header")}
      (str title " ( " cards-in-section " )")])
   (when is-backlog (new-card-input))
   [card-list current-section-cards button-text next-section-cards]])
