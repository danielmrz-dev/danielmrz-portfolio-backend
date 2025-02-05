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
}