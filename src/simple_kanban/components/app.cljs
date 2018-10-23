(ns simple-kanban.components.app
  (:require [simple-kanban.components.section :as section]
            [simple-kanban.state :refer [in-backlog
                                         in-dev
                                         in-test
                                         in-done]]))

(defn render []
  [:div {:class "app"}
   [:h1 {:id "title"} "Simple Kanban"]
   [:div {:class "container"}
    [section/render "Backlog" "Advance" in-backlog in-dev true false]
    [section/render "In Development" "Advance" in-dev in-test false true]
    [section/render "In Testing" "Advance" in-test in-done false false]
    [section/render "Done" "Archive" in-done nil false false]]])