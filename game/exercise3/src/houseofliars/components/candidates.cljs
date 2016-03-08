(ns houseofliars.components.candidates
  (:require
   [reagent.core :as reagent]
   [houseofliars.state :as state :refer [app-state]]
   [houseofliars.components.button :as button]
   [houseofliars.utils :as utils]))

(defn candidate-component
  "Renders the candidate component"
  [{:keys [id fname lname party head]}]
  (let [{:keys [toggle animate]} (get-in @app-state [:animate id])
        headClass (str "head-img animated " (when toggle animate))]
    [:div.col-xs-2
     [:div.podium
      [:h4.name  (str fname " " lname)]
      [:img {:className headClass :src head}]
      [:img {:className "podium-img" :src "/img/podium.png "}]
      [button/button-component id]]]))

(defn candidates-component
  "Renders the container for the candidate components"
  []
  [:div#candidateContainer
   (for [candidate (:candidates @app-state)]
     ^{:key (:id candidate)}
     [candidate-component candidate])])
