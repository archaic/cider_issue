(ns cider-issue.core
  (:import [com.gargoylesoftware.htmlunit WebClient BrowserVersion]))

(defn issue []
  (let [client (WebClient. BrowserVersion/CHROME)
        options (.getOptions client)
        _ (.setThrowExceptionOnScriptError options false)

        base "http://www.thedogs.com.au"
        page (.getPage client (str base "/Racing/Racing.aspx"))
        
        field-selector
        "//input[contains(@id,'btnFields')]"]

    (.getByXPath page "//input[contains(@id,'btnFields')]")))


#_(issue) ; might take 10-20s to load page

;; => error in process filter: clojure-string-start: Search failed: "\\(\\s-\\|^\\|#\\|(\\|\\[\\|{\\)\\(\"\\)"
;; => error in process filter: Search failed: "\\(\\s-\\|^\\|#\\|(\\|\\[\\|{\\)\\(\"\\)"
