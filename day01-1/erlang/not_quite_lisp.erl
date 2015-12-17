-module(not_quite_lisp).
-include_lib("eunit/include/eunit.hrl").
-export([what_floor/1, when_basement/1]).

what_floor_ground_floor_test() -> 0 = what_floor("(())").
what_floor_second_floor_test() -> 2 = what_floor("(()(").
what_floor_second_basement_test() -> -2 = what_floor("(())))").

what_floor(Instructions) ->
    what_floor_iter(Instructions, 0).

what_floor_iter([$(|T], Floor) ->
    what_floor_iter(T, Floor + 1);
what_floor_iter([$)|T], Floor) ->
    what_floor_iter(T, Floor - 1);
what_floor_iter([], Floor) ->
    Floor.

when_basement_never_test() -> 0 = when_basement("(())").
when_basement_first_test() -> 1 = when_basement(")(()").
when_basement_fifth_test() -> 5 = when_basement("(()))()").

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