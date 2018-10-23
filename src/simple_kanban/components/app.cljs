(ns simple-kanban.components.app
  (:require [simple-kanban.components.section :as section]
            [simple-kanban.state :as state]))

(defn render []
  [:div {:class "app"}
   [:h1 {:id "title"} "Simple Kanban"]
   [:div {:class "container"}
    [section/render "Backlog" "Advance" state/in-backlog state/in-dev true false]
    [section/render "In Development" "Advance" state/in-dev state/in-test false true]
    [section/render "In Testing" "Advance" state/in-test state/in-done false false]
    [section/render "Done" "Archive" state/in-done nil false false]]])