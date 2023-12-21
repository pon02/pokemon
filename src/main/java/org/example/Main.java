package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args)  {

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

        try {
            if (pKey == null || pKey.isEmpty()) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("未入力です。");
            System.exit(0);
        }
        try {
            if (pKey != null && !pKey.matches("[ァ-ヶー]+")) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
                System.out.println("カタカナで入力してください。");
                System.exit(0);
        }
        try{
            if (!pokemonMap.containsKey(pKey)) {
                throw new PokemonNotFoundException("そのポケモンはまだゲットしていません。");
            } else  {
                System.out.println("そのポケモンの種類は" + pokemonMap.get(pKey) + "です。");
            }
        } catch (PokemonNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }
}