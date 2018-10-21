(ns simple-kanban.components.app
  (:require [simple-kanban.components.section :as section]
            [simple-kanban.state :as state]))

(defn component []
  [:div {:class "app"}
   [:h1 {:id "title"} "Simple Kanban"]
   [:div {:class "container"}
    (section/component "Backlog" "Advance" state/in-backlog state/in-dev true)
    (section/component "In Development" "Advance" state/in-dev state/in-test false)
    (section/component "In Testing" "Advance" state/in-test state/in-done false)
    (section/component "Done" "Archive" state/in-done nil false)]])