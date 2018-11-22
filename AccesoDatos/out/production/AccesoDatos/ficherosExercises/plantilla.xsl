<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <xsl:apply-templates/>
        </html>
    </xsl:template>
    <xsl:template match="ListaContactosAgenda">
        <head>
            <title>LISTADO DE CONTACTOS</title>
        </head>
        <body>
            <h1>LISTA DE CONTACTOS</h1>
            <table border="1">
                <tr>
                    <th>Nombre</th>
                    <th>Telefono</th>
                    <th>Address</th>
                    <th>Nacimiento</th>
                    <th>CP</th>
                    <th>Dinero</th>
                    <th>Cantidad</th>
                </tr>
                <xsl:apply-templates select="DatosContacto"/>
            </table>
        </body>
    </xsl:template>
    <xsl:template match="DatosContacto">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="name|tel|address|birth|postal|money|amount">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>