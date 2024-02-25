package controlador;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;


public class Consulta {
    public static String[] getRecipes2(String nombre) {
            
	    String[] recipes = new String[1]; 

            // Crear un array de tamaño 3 para guardar las 3 recetas
	    try {
	    		String enlace2="https://api.spoonacular.com/recipes/findByIngredients?ingredients=apples,fluor,sugar,&number=1&apiKey=e0cb6e61b46640608b2ed3ce0f3d1387";
	    	/*https://api.spoonacular.com/recipes/complexSearch?query="+nombre+"&cuisine="+cuisine+"&diet="+diet+"&intolerances="+intolerances+"&sort="+ordenar+"&maxFat=2&number=3&addRecipeInformation=true&apiKey=2492314357914d508e7b8386c8310b01*/
                String enlace="https://api.spoonacular.com/recipes/complexSearch?query="+nombre+"&addRecipeInformation=true&apiKey=e0cb6e61b46640608b2ed3ce0f3d1387";

	        URL url;
                url = new URL(enlace);
	        HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
	        conexion.setRequestMethod("GET");
	        conexion.connect();
	        int respuesta = conexion.getResponseCode();
	        if (respuesta != 200) {
	            throw new RuntimeException("Ocurrió un error: " + respuesta);
	        } else {
	            StringBuilder info = new StringBuilder();
	            Scanner sc = new Scanner(url.openStream());

	            while (sc.hasNext()) {
	                info.append(sc.nextLine() + "\n");
	            }
	            sc.close();

	            JSONObject jsonObject = new JSONObject(info.toString());
	            JSONArray results = jsonObject.getJSONArray("results");

	            // Itera a través de cada objeto de resultado
	            for (int i = 0; i < results.length(); i++) {
	                JSONObject result = results.getJSONObject(i);

	                // Obtener valores individuales
	                String title = result.getString("title");
	                String image = result.getString("image");
	                String contenido = result.getString("summary");
	                int minutos=result.getInt("readyInMinutes");
	                String dat=result.getString("spoonacularSourceUrl");
	               
	                // Agrega la receta al array
	                recipes[i] = "<div class='col border border-secondary rounded m-2 shadow '>"
                                + "<h1 class='d-flex justify-content-center display-6 mt-4 mb-4'> " + title + "</h1>"
                                + "<div><img src=\"" + image + "\" class='mx-auto d-block rounded shadow '>"
                                + "<ul class='m-4 list-unstyled'><li>"+minutos+" minutos</li><li><a href='"+dat+"'>"+dat+"<a></li></ul>"
                                + "<p class='text-right m-4'>"+contenido+"</p></div></div>";
                       
                    };
	        }
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return recipes;
	}
    
    public static String devolverNombre(String nombre) {
    	
    	String title="";
    	try {
	    	String enlace="https://api.spoonacular.com/recipes/findByIngredients?ingredients="+nombre+"&number=1&apiKey=e0cb6e61b46640608b2ed3ce0f3d1387";
	    	URL url;
	        url = new URL(enlace);
		    HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
		    conexion.setRequestMethod("GET");
		    conexion.connect();
		    int respuesta = conexion.getResponseCode();
		    if (respuesta != 200) {
		    	throw new RuntimeException("Ocurrió un error: " + respuesta);
		    }else {
		
	    	StringBuilder info = new StringBuilder();
            Scanner sc;
			
				sc = new Scanner(url.openStream());
			
            while (sc.hasNext()) {
                info.append(sc.nextLine() + "\n");
            }
            sc.close();

            //JSONObject json = new JSONObject(info.toString());
            JSONArray jsonArray = new JSONArray(info.toString());
            String titulo="";
	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	
	            int id = jsonObject.getInt("id");
	            titulo = jsonObject.getString("title");
	            String image = jsonObject.getString("image");
	            int usedIngredientCount = jsonObject.getInt("usedIngredientCount");
	            int missedIngredientCount = jsonObject.getInt("missedIngredientCount");
	
	            System.out.println("ID: " + id);
	            System.out.println("Title: " + titulo);
	            System.out.println("Image: " + image);
	            System.out.println("Used Ingredient Count: " + usedIngredientCount);
	            System.out.println("Missed Ingredient Count: " + missedIngredientCount);
	        }
	        title=titulo;
		}
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    	return title;
    }
    public static String[] getRecipes3(String nombre, String cuisine, String diet, String intolerances, String ordenar) {
            
	    String[] recipes = new String[8]; 

            // Crear un array de tamaño 3 para guardar las 3 recetas
	    try {
                String enlace="https://api.spoonacular.com/recipes/complexSearch?query="+nombre+"&cuisine="+cuisine+"&diet="+diet+"&intolerances="+intolerances+"&sort="+ordenar+"&number=8&addRecipeInformation=true&apiKey=2492314357914d508e7b8386c8310b01";

	        URL url;
                url = new URL(enlace);
	        HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
	        conexion.setRequestMethod("GET");
	        conexion.connect();
	        int respuesta = conexion.getResponseCode();
	        if (respuesta != 200) {
	            throw new RuntimeException("Ocurrió un error: " + respuesta);
	        } else {
	            StringBuilder info = new StringBuilder();
	            Scanner sc = new Scanner(url.openStream());

	            while (sc.hasNext()) {
	                info.append(sc.nextLine() + "\n");
	            }
	            sc.close();

	            JSONObject jsonObject = new JSONObject(info.toString());
	            JSONArray results = jsonObject.getJSONArray("results");

	            // Itera a través de cada objeto de resultado
	            for (int i = 0; i < results.length(); i++) {
	                JSONObject result = results.getJSONObject(i);

	                // Obtener valores individuales
	                int id = result.getInt("id");
	                String title = result.getString("title");
	                String image = result.getString("image");
	                String contenido = result.getString("summary");

	                // Acceder a las instrucciones
	               
                         JSONArray analyzedInstructions = result.getJSONArray("analyzedInstructions");
                        String acumulado="";
                        String acum2="";
                        String ingre="";
                        String ingredientNames = "";
                        for (int f = 0; f < analyzedInstructions.length(); f++) {
                            JSONArray steps = analyzedInstructions.getJSONObject(f).getJSONArray("steps");
                            
                            for (int j = 0; j < steps.length(); j++) {
                                JSONObject step = steps.getJSONObject(j);
                                int number = step.getInt("number");
                                String stepDesc = step.getString("step");
                                acumulado+= j+1+"."+stepDesc+ "<br>";
                                
                                JSONArray ingredients = step.getJSONArray("ingredients");
                                for (int k = 0; k < ingredients.length(); k++) {
                                    JSONObject ingredient = ingredients.getJSONObject(k);
                                    String name = ingredient.getString("name");
                                    ingredientNames += "<li>"+name +"</li> ";
                                }
                            }
                            ingre+=ingredientNames;
                            acum2+= acumulado;
                        }
	                // Agrega la receta al array
	                recipes[i] = "<div class='col border border-secondary rounded m-2 shadow '>"
                                + "<h1 class='d-flex justify-content-center display-6 mt-4 mb-4'> " + title + "</h1>"
                                + "<div><img src=\"" + image + "\" class='mx-auto w-150 h-250 rounded shadow '>"
                                + "<div class='row d-block overflow-auto' style='max-width:400px; max-height:250px'><ul class='m-4 list-unstyled'>"
                                + "<li>"+ingre+"</li></ul>"
                                
                                + "<p class='text-right m-4'>"+acum2+"</p></div></div>"
                                + "</div>";
                       
                    };
	        }
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return recipes;
	}
}

