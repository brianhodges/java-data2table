package data2table;

public class main {

	public static void main(String[] args) {
		Country c1 = new Country("USA", "350 million");
        Country c2 = new Country("China","1.4 billion");
        Country c3 = new Country("Russia","145 million");
        Country[] countries = {c1, c2, c3};
        System.out.println("SANITIZED DUMP:");
        for (int x = 0; x < countries.length; x++)  {
        	String hash = String.format("{ :name => %s, :population => %s }", countries[x].name, countries[x].population);
        	System.out.println(hash);
        }
        System.out.println();
        System.out.println("TABLE:");
        System.out.println("Countries | Population");
        String border = new String(new char["Countries | Population".length()]).replace("\0", "-");
        System.out.println(border);
        for (int x = 0; x < countries.length; x++)  {
        	String whitespace = new String(new char["Countries ".length() - countries[x].name.length()]).replace("\0", " ");
        	System.out.format("%s%s|%s", countries[x].name, whitespace, countries[x].population);
        	System.out.println();
        }
	}

}

class Country {
	   String name;
	   String population;
	   Country(String name, String population) {
		   this.name = name;
		   this.population = population;
	   }
}