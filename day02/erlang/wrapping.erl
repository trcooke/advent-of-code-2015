-module(wrapping).
-include_lib("eunit/include/eunit.hrl").
-export([how_much_paper/1]).

how_much_paper_1_test() -> 58 = how_much_paper("2x3x4").
how_much_paper_2_test() -> 43 = how_much_paper("1x1x10").

how_much_paper(Dimentions) ->
    [{{W,_}},{{L,_}},{{H,_}}] = lists:map(fun(X) -> {string:to_integer(X)} end, string:tokens(Dimentions,"x")),
    LW = L*W,
    WH = W*H,
    HL = H*L,
    2*LW + 2*WH + 2*HL + lists:min([LW,WH,HL]).
