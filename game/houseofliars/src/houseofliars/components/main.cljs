(ns houseofliars.components.main
  (:require
   [reagent.core :as reagent]
   [houseofliars.state :as state :refer [app-state]]
   [houseofliars.components.message :as message]
   [houseofliars.components.candidates :as candidates]
   ))

(defn game-title
  "Renders the game title component. Uses the :game-title key in app-state."
  []
  [:div.row
   [:h1#gameTitle (:game-title @app-state)]])

(defn main
  "The main component which will wrap all of our sub-components"
  []
  [:div.container
   [game-title]
   [message/message-component]
   [candidates/candidates-component]])
