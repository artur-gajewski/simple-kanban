FROM clojure:lein-2.8.1-alpine
WORKDIR /app
CMD ["lein", "figwheel"]