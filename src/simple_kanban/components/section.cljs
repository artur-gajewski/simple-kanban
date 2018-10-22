(ns simple-kanban.components.section
  (:require [simple-kanban.components.new-card-input :as new-card-input]
            [simple-kanban.components.card-list :as card-list]
            [simple-kanban.state :as state]))

(defn component [title button-text section-state advance-to is-backlog]
  [:div {:class "section"}
   [:div {:class "column-header"} (str title " ( " (count @section-state) " )")]
   (when is-backlog (new-card-input/component))
   [card-list/component section-state button-text advance-to]])
