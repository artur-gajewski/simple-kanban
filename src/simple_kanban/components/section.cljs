(ns simple-kanban.components.section
  (:require [simple-kanban.components.new-card-input :as new-card-input]
            [simple-kanban.components.card-list :as card-list]))

(defn render [title button-text section-state advance-to is-backlog enable-alert]
  [:div {:class "section"}
   [:div {:class "column-header"}
    (str title " ( " (count @section-state) " )")
    (when enable-alert
      (when (> (count @section-state) 3)
        [:span {:class "alert"} "!!!"]))]
   (when is-backlog (new-card-input/render))
   [card-list/render section-state button-text advance-to]])
