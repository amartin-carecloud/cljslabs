(ns houseofliars.components.candidates
  (:require
   [reagent.core :as reagent]
   [houseofliars.state :as state :refer [app-state]]
   [houseofliars.utils :as utils]))

(defn candidate-component
  "Renders the candidate component"
  [{:keys [id fname lname party head]}]
    [:div.col-xs-2
     [:div.podium
      [:h4.name  (str fname " " lname)]
      [:img {:className "head-img animated" :src head}]
      [:img {:className "podium-img" :src "/img/podium.png "}]]])

(defn candidates-component
  "Renders the container for the candidate components"
  []
  [:div#candidateContainer

  ;; Add your code here

   ])
