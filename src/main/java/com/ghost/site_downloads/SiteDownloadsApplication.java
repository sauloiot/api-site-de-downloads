package com.ghost.site_downloads;


import com.ghost.site_downloads.models.*;
import com.ghost.site_downloads.models.enums.UserType;
import com.ghost.site_downloads.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Profile("default")
@SpringBootApplication
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SiteDownloadsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SiteDownloadsApplication.class, args);
    }



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AccUserRepository accUserRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ImagesRepository imagesRepository;
    @Autowired
    private LinkRepository linkRepository;

    @Override
    public void run(String... args) throws Exception {

        AccUser admin = new AccUser(null, "admin", "admin@hotmail.com", bCryptPasswordEncoder.encode("123456"));
        admin.setUserType(UserType.ADMIN);
        AccUser user = new AccUser(null, "user", "user@hotmail.com", bCryptPasswordEncoder.encode("123456"));
        Category filmes = new Category(null, "Filmes", "Filmes, Series, Desenhos e Animes", admin);
        Category jogos = new Category(null, "jogos", "jogos, jogos, jogos e jogos", admin);
        SubCategory acao = new SubCategory(null, "acao", "Filmes de acao", admin, filmes);
        SubCategory terror = new SubCategory(null, "terror", "Filmes de terror", admin, filmes);
        SubCategory aventura = new SubCategory(null, "aventura", "Filmes de aventura", admin, filmes);
        SubCategory drama = new SubCategory(null, "drama", "Filmes de drama", admin, filmes);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Item mulherMaravilha = new Item(null, "Mulher Maravilha 1984", "Filme da mulher maravilha", sdf.parse("01/06/2017"), sdf.parse("21/01/2021"), admin, acao);
        Images imagemFilmes = new Images(null, "www.filmes.com/imagem-filmes",filmes,null, null);
        Images imagemAcao = new Images(null, "www.acao.com/imagem-acao",null,acao, null);
        Images imagemMulherMaravilha = new Images(null, "www.mulhermaravilha.com/imagem-mulher-maravilha",null,null, mulherMaravilha);
        Link linkDownloadMulherMaravilha = new Link(null, "magnet:hijdaidjiasdiaidasd.eee323213ddd.torrent", "Mulher Maravilha Full HD Dublado", mulherMaravilha);

        Item ironman = new Item(null, "ironman 2", "Filme do ironman 2", sdf.parse("01/06/2017"), sdf.parse("21/01/2021"), admin, acao);


        accUserRepository.saveAll(Arrays.asList(admin, user));
        categoryRepository.saveAll(Arrays.asList(filmes, jogos));
        subCategoryRepository.saveAll(Arrays.asList(acao, terror, aventura, drama));
        itemRepository.saveAll(Arrays.asList(mulherMaravilha, ironman));
        imagesRepository.saveAll(Arrays.asList(imagemFilmes,imagemAcao,imagemMulherMaravilha));
        linkRepository.saveAll(Arrays.asList(linkDownloadMulherMaravilha));


    }
}
