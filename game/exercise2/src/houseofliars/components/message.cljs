(ns houseofliars.components.message
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [reagent.core :as reagent]
   [houseofliars.state :as state :refer [app-state]]
   [houseofliars.utils :as utils]))

(defn game-over-component
  "Renders the game over message and displays the final assessment."
  []
  [:div
   [:p.game-over "Game Over"]
   [:p.assesment ""]])

(defn candidate-quote-component
  "Renders the candidate quote inside of a blockquote element"
  [{:keys [candidate_id quote]}]
  [:blockquote {:data-candidate-id candidate_id} quote])

(defn quote-component
  "Renders the quote container which displays the quote
or the final assessment."
  []
  [:div.quote-container

   ;; Add your code here


  ])

(defn score-component
  "Renders the score component."
  [label key]
  [:div.score-container
   [:h3.label label]
   [:h2.score (get-in @app-state [:score key])]])

(defn message-component
  "Renders the message component"
  []
  [:div.message-container
   [:div.col-xs-2
    [score-component "Detected" :right]]
   [:div.col-xs-8
    [quote-component]]
   [:div.col-xs-2
    [score-component "Missed" :wrong]]])
