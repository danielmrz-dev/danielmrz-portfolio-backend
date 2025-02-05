import { projeto } from "../models/projeto.js";


export class ProjetoController {

    static async listaProjetos(req, res) {
        try {
            const listaDeProjetos = await projeto.find({});
            res.status(200).json(listaDeProjetos);
        } catch (error) {
            res.status(500).json({ mensagem: `${error} - Falha na requisição.` })
        }
    }

    static async buscaProjetoPorId(req, res) {
        try {
            const id = req.params.id;
            const projetoEncontrado = await projeto.findById(id);
            res.status(200).json(projetoEncontrado)
        } catch (error) {
            res.status(404).json({ mensagem: "Projeto não encontrado." })
        }
    }

    static async criaProjeto(req, res) {
        try {
            const novoProjeto = req.body;
            await projeto.create(novoProjeto);
            res.status(201).json({ mensagem: "Projeto cadastrado com sucesso." })
        } catch (error) {
            res.status(500).json({ mensagem: `Houve um erro ao cadastrar o projeto. => ${error}.` })
        }
    }

    static async editaProjeto(req, res) {
        try {
            const id = req.params.id;
            await projeto.findByIdAndUpdate(id, req.body)
            res.status(200).json({ mensagem: "Projeto editado com sucesso." })
        } catch (error) {
            res.status(500).json({ mensagem: `${error} - Houve um erro ao tentar editar o projeto.` })
        }
    }

    static async excluiProjeto(req, res) {
        try {
            const id = req.params.id;
            await projeto.findByIdAndDelete(id);
            res.status(200).json({ mensagem: `Projeto excluído com sucesso.` })
        } catch (error) {
            res.status(500).json({ mensagem: `${error} - Houve um erro ao excluir o projeto.` })
        }
    }
}