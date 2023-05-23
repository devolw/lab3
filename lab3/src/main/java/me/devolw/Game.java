package me.devolw;

import lombok.Getter;
public class Game {
	@Getter private String name;        //Название игры
	@Getter private String genre;       //Жанр
	@Getter private String platform;    //Платформа
	@Getter private float year;         //Год
	@Getter private float price;        //Цена

	public Game(String name, String genre, String platform, float year, float price) {
		this.name = name;
		this.genre = genre;
		this.platform = platform;
		this.year = year;
		this.price = price;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null || getClass()!=obj.getClass()) return false;
		Game game = (Game) obj;
		if(!name.equals(game.name)) return false;
		if(!genre.equals(game.genre)) return false;
		if(!platform.equals(game.platform)) return false;
		if(year != game.year) return false;
		return price == game.price;
		
	}
	@Override
	public int hashCode() {
		int result = (int) ((int)price ^ ((int)price >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + platform.hashCode();
        result = 31 * result + (int) year;
        return result;
	}
}