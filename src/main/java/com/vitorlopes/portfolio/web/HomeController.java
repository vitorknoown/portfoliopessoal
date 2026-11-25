package com.vitorlopes.portfolio.web;

import com.vitorlopes.portfolio.config.PerfilProperties;
import com.vitorlopes.portfolio.service.ContatoService;
import com.vitorlopes.portfolio.service.PortfolioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    private final PerfilProperties perfil;
    private final PortfolioService portfolioService;
    private final ContatoService contatoService;

    public HomeController(PerfilProperties perfil,
                          PortfolioService portfolioService,
                          ContatoService contatoService) {
        this.perfil = perfil;
        this.portfolioService = portfolioService;
        this.contatoService = contatoService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (!model.containsAttribute("contatoForm")) {
            model.addAttribute("contatoForm", new ContatoForm());
        }
        carregarPortfolio(model);
        return "index";
    }

    @PostMapping("/contato")
    public String enviarContato(@Valid @ModelAttribute("contatoForm") ContatoForm form,
                                BindingResult result,
                                Model model,
                                RedirectAttributes redirect) {
        if (result.hasErrors()) {
            // Renderiza a página de novo para mostrar os erros ao lado dos campos.
            carregarPortfolio(model);
            return "index";
        }
        contatoService.registrar(form);
        redirect.addFlashAttribute("mensagemSucesso",
                "Mensagem enviada! Obrigado pelo contato, responderei em breve.");
        // Padrão Post/Redirect/Get: evita reenvio ao atualizar a página.
        return "redirect:/#contato";
    }

    private void carregarPortfolio(Model model) {
        model.addAttribute("perfil", perfil);
        model.addAttribute("habilidades", portfolioService.habilidadesPorCategoria());
        model.addAttribute("experiencias", portfolioService.experiencias());
        model.addAttribute("certificacoes", portfolioService.certificacoes());
        model.addAttribute("projetos", portfolioService.projetos());
    }
}
