Antes de usar a aplicação é necessario acessar duas classes para que possa ser feito o envio dos emails referentes aos saques e depositos para isso estarei deixando o passo a passo de como fazer

1.Acesse https://myaccount.google.com e procure pela barra de pesquisa no canto superio da tela e pesquise "Senhas de app"
![barra de pesquisa](https://github.com/gastvi/Teste-Desenvolvedor-Backend-Java-Jr.---tgid/assets/60610675/c94b7581-f6f8-4664-aafa-75292d8bb2f5)
2.Crie um nome pro seu app
![nome app](https://github.com/gastvi/Teste-Desenvolvedor-Backend-Java-Jr.---tgid/assets/60610675/adf2becd-5ffe-40fe-8575-ddd9979d1776)
3. ao criar ele irá gerar uma senha, copie essa senha sem os espaços
4. cole essa senha na classe "MailConfiguration" no campo mailSender.setPassoword e um email que precisa ser do gmail.com no campo mailSender.setUsername que será usado para mandar os emails(é necessario ter dois email para funcionar sendo um do gmail.com)
![MailConfiguration](https://github.com/gastvi/Teste-Desenvolvedor-Backend-Java-Jr.---tgid/assets/60610675/315f8a51-9290-4af4-8bc9-aebfa4049fe8)
5.Agora vá para o arquivo "application properties" e coloque a senha que copiou antes e seu email em seus respequetivos campos
![application properties](https://github.com/gastvi/Teste-Desenvolvedor-Backend-Java-Jr.---tgid/assets/60610675/5e42e078-384f-48e6-a380-258b815619a1)
6.Agora é só rodar o projeto



