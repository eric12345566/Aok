<html>
<head>
  <title>${title}</title>
</head>
<body>
  <h1>${title}</h1>

  <p>${exampleObject.name} by 你好 ${exampleObject.developer}</p>

  <ul>
    <#list exampleObject.dataList as system>
      <li>${system_index + 1}. ${system.name} from ${system.developer}</li>
    </#list>
  </ul>

</body>
</html>
