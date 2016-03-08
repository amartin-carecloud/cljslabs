(ns houseofliars.components.main
  (:require
   [reagent.core :as reagent]
   [houseofliars.state :as state :refer [app-state]]))

;; Create Your Game component here

;; Add your game component to the Main component fn
(defn main
  "The main component which will wrap all of our sub-components"
  []
  [:div.container])
