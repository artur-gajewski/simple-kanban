(ns simple-kanban.core
  (:require [reagent.core :as reagent]
            [simple-kanban.components.app :refer [app]]))

(defn mount-root []
  (reagent/render [app] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
