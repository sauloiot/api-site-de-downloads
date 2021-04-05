//package com.ghost.site_downloads.config;
//
//import com.ghost.site_downloads.models.Category;
//import com.ghost.site_downloads.repositories.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//
//import java.util.Arrays;
//
//public class DbLoad implements CommandLineRunner {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Category cat1 = new Category(1, "Filmes", "Filmes, Series, Desenhos e Animes");
//        Category cat2 = new Category(2, "Jogos", "Jogos, Cracks, Updates, Dlcs e Expansões");
//        Category cat3 = new Category(3, "Programas", "Programas, Cracks e Atualizações");
//        Category cat4 = new Category(4, "Livros", "Livros e Mangas");
//
//        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
//
//    }
//}
