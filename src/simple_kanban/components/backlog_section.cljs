(ns simple-kanban.components.backlog-section
  (:require [simple-kanban.components.new-card-input :as new-card-input]
            [simple-kanban.components.card-list :as card-list]
            [simple-kanban.utils :as utils]
            [simple-kanban.state :as state]))

(defn component []
  [:div {:class "section"} [:div {:class "column-header"} (str "Backlog ( " (count @state/in-backlog) " )")]
   [new-card-input/component]
   [card-list/component state/in-backlog "Advance" state/in-dev]])
