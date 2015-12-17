-module(not_quite_lisp).
-export([what_floor/1, when_basement/1]).

what_floor(Instructions) ->
    what_floor_iter(Instructions, 0).

what_floor_iter([$(|T], Floor) ->
    what_floor_iter(T, Floor + 1);
what_floor_iter([$)|T], Floor) ->
    what_floor_iter(T, Floor - 1);
what_floor_iter([], Floor) ->
    Floor.

when_basement(Instructions) ->
    when_basement_iter(Instructions, 0, 0).

when_basement_iter(_, -1, Count) ->
    Count;
when_basement_iter([$(|T], Floor, Count) ->
    when_basement_iter(T, Floor + 1, Count + 1);
when_basement_iter([$)|T], Floor, Count) ->
    when_basement_iter(T, Floor - 1, Count + 1);
when_basement_iter([], _, _) ->
    0.