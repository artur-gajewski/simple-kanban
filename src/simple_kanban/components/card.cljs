(ns simple-kanban.components.card
  (:require [simple-kanban.actions :refer [advance-card]]))

(defn card [task current-section-cards button-text next-section-cards]
  (let [{:keys [id description owner]} (val task)]
    ^{:key id}
    [:li
     [:div
      [:b "Task: "] description]
     [:div
      [:b "Owner: "] owner]
     [:div
      [:button {:class "advance-card-button"
                :on-click #(advance-card task current-section-cards next-section-cards)}
       button-text]]]))
