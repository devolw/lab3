package me.devolw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileHandler {
	private static String pathStr = "/Users/daniilpopoff/Downloads/lab3/src/main/webapp/game.dat";
	private static Path path = Paths.get(pathStr);
	public static void writeGameToFile(Game game) throws IOException {
		String gameString = "";
		gameString+=game.getName()+",";
		gameString+=game.getGenre()+",";
		gameString+=game.getPlatform()+",";
		gameString+=game.getYear()+",";
		gameString+=game.getPrice()+"\n";
		if(!Files.exists(path)) {
			Files.createFile(path);
		}
		Files.write(path, gameString.getBytes(), StandardOpenOption.APPEND);
	}
	public static ArrayList<Game> readGamesFromFile() throws IOException {
		if(Files.exists(path)) {
		BufferedReader reader = new BufferedReader(new FileReader(pathStr));
		String data = reader.readLine();
		ArrayList<Game> game = new ArrayList<>();
		while(data != null) {
			String[] parameters = data.split(",");
			Game tempGame = new Game(parameters[0],parameters[1],parameters[2],Float.parseFloat(parameters[3]),Float.parseFloat(parameters[4]));
			game.add(tempGame);
			data = reader.readLine();
		}
		reader.close();
		return game;
		}
		return null;
	}
}
