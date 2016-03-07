(ns fkngliars1.components.main
  (:require
   [reagent.core :as reagent]
   [fkngliars1.state :as state :refer [app-state]]))

(defn select-random-quote
  []
  (let [hasQuote? (< 0 (count (:quotes @app-state)))
        quote (when hasQuote? (rand-nth (:quotes @app-state)))]
    (swap! app-state assoc-in [:tracker :current-quote] quote)
    quote))

(defn remove-quote-from-list
  []
  (let [current-quote (get-in @app-state [:tracker :current-quote])
        filtered-quotes (vec (filter #(not= % current-quote) (:quotes @app-state)))]
    (swap! app-state assoc-in [:quotes] filtered-quotes)))

(defn final-assesment
  []
  (let [{:keys [right wrong]} (get-in @app-state [:score])
        even? (= right wrong)
        winner? (> right wrong)]
    (cond
      even?
      "Sharpen up your lie detecting skills"

      winner?
      "You're a born lie detector!"

      :else
      "Don't be such a rube!")
    )
  )

(defn game-over-component
  []
  [:div
   [:p.game-over "Game Over"]
   [:p.assesment (final-assesment)]])


(defn candidate-quote
  [{:keys [id quote]}]
  [:blockquote {:data-candidate-id id} quote])

(defn quote-component
  []
  (let [hasQuote? (< 0  (count (:quotes @app-state)))
        quote (when hasQuote? (select-random-quote))]
    [:div.quote-container
     (if-not (nil? quote)
       [candidate-quote quote]
       [game-over-component])]))

(defn score-component
  [label key]
  [:div.score-container
   [:h3.label label]
   [:h2.score (get-in @app-state [:score key])]])

(defn message-component
  []
  [:div.message-container
   [:div.col-xs-2
    [score-component "Detected" :right]]
   [:div.col-xs-8
    [quote-component]]
   [:div.col-xs-2
    [score-component "Missed" :wrong]]])

(defn button-component-did-mount
  [this]
  (js/$
   (fn[]
     (let [$this (js/$ (.getDOMNode this))]       
       (.on $this "click"
            (fn [event]
              (let [$target (js/$ (.-target event))
                    candidateId (.-candidateId (.data $target))
                    {:keys [candidate_id quote]} (get-in @app-state [:tracker :current-quote])]
                (when (<= 1 (count (:quotes @app-state)))
                  (if (= candidateId candidate_id)
                    (swap! app-state update-in [:score :right] inc)
                    (swap! app-state update-in [:score :wrong] inc))                  
                  (remove-quote-from-list)
                  (select-random-quote)))))))))

(defn button-component
  [id]
  (reagent/create-class
   {:reagent-render (fn [id]
                      [:button {:className "btn btn-lg btn-primary outline"
                                :data-candidate-id id}
                       "LIAR!"])
    :component-did-mount button-component-did-mount
    }))

(defn candidate-component
  [{:keys [id fname lname party head]}]
  [:div.col-xs-2
   [:div.podium
    [:h4 (str fname " " lname)]
    [:h5 party]
    [:img {:className "head-img" :src head}]
    [:img {:className "podium-img" :src "/img/podium.png "}]
    [button-component id]]])

(defn candidates-container
  []
  [:div#candidateContainer
   (for [candidate (:candidates @app-state)]
     ^{:key (:id candidate)}
     [candidate-component candidate]
     )])

(defn game-title
  []
  [:div.row
   [:h1#gameTitle "F*CKING LIARS!"]])

(defn main
  "The main component which will wrap all of our sub-components"
  []
  [:div.container
   [game-title]
   [candidates-container]
   [message-component]])
