(ns fkngliars1.components.main
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [reagent.core :as reagent]
   [cljs.core.async :as async :refer [timeout chan <!]]
   [fkngliars1.state :as state :refer [app-state]]
   [fkngliars1.components.message :as message]
   [fkngliars1.components.candidates :as candidates]
   ))

(defn game-title
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
