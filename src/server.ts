import express from 'express';

const app = express();
const PORT = 3000;

app.get("/", (req, res) => {
    res.json({ mensagem: "Server running!" })
})

app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}.`);    
})
