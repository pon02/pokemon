package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) throws PokemonNotFoundException {

        List<String> pokemon = new ArrayList<>();
        pokemon.add("ピカチュウ:電気");
        pokemon.add("フシギダネ:草");
        pokemon.add("ヒトカゲ:火");
        pokemon.add("コイキング:水");

        Map<String,String> pokemonMap = new HashMap<>();
        for (String p : pokemon) {
            String[] items = p.split(":");
            String value = items[1];
            String key = items[0];
            pokemonMap.put(key,value);
        }

        System.out.println("ポケモンの名前を入力してください。");
        Scanner input = new Scanner(System.in);
        String pKey = input.nextLine();

        if (!pokemonMap.containsKey(pKey)) {
            throw new PokemonNotFoundException("そのポケモンはまだゲットしていません。");
        }

        System.out.println("そのポケモンの種類は" + pokemonMap.get(pKey) + "です。");

    }
}