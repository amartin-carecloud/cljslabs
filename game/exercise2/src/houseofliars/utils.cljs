(ns houseofliars.utils
  (:require
   [reagent.core :as reagent]
   [houseofliars.state :as state :refer [app-state]]))

(defn select-random-quote
  "Adds a quote to the [:tracker :current-quote] key in the app-state.
Returns the quote.
"
  []
  (let [hasQuote? (< 0 (count (:quotes @app-state)))
        quote (when hasQuote? (first (:quotes @app-state)))]
    (swap! app-state assoc-in [:tracker :current-quote] quote)
    quote))





