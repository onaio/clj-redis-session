clj-redis-session
=================

[![Build Status][travis-badge]][travis]


What is it?
-----------

`clj-redis-session` uses redis as a Clojure/Ring's HTTP session
storage engine. What makes it different is its support for
hierarchical data, actually any `*print-str*`able clojure data types.


Why?
----

The reason I wrote `clj-redis-session` is that the only Redis-backed
sesssion store I could find ([rrss][rrss])
doesn't support hierarchical data structures, e.g. lists, maps.


Installation
------------

Add
```clojure

[clj-redis-session "2.1.3"]
```
to `:dependencies` in your `project.clj`.


Usage
-----

`clj-redis-session` is a drop-in replacement for Ring native session
stores. `clj-redis-session` uses
[Carmine][carmine] as its Redis client.
```clojure

(ns hello
  (:use
    ring.middleware.session
    [clj-redis-session.core :only [redis-store]]))

;; clj-redis-session use Carmine as its Redis client
(def redis-conn {:pool {<pool-opts>} :spec {<spec-opts>}})

(def app
  (-> your-routes
      ... other middlewares ...
      (wrap-session {:store (redis-store redis-conn)})
      ....))
```
Want sessions to automatically expire?
```clojure

# expire after 12 hours
(wrap-session your-app {:store (redis-store redis-conn {:expire-secs (* 3600 12)})})
```

Extend session expiration time while reading the session
```clojure
# everytime when session gets read, it will reset current session expiration time.
(wrap-session your-app {:store (redis-store redis-conn {:expire-secs (* 3600 12)
                                                        :reset-on-read true})})
```

You can also change the prefix (default to `session`) for the keys in
redis:
```clojure

(wrap-session your-app {:store (redis-store redis-conn {:prefix "i-am-prefix"})})
```


License
-------

Copyright (C) 2013 Zhe Wu <wu@madk.org>

Distributed under the Eclipse Public License, the same as Clojure.


[travis]: https://travis-ci.org/wuzhe/clj-redis-session
[travis-badge]: https://travis-ci.org/wuzhe/clj-redis-session.png?branch=master
[rrss]: https://github.com/paraseba/rrss
[carmine]: https://github.com/ptaoussanis/carmine
