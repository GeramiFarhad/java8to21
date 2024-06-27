package eleven.modules.TestModuleFarm3.farm.stock.sale.farm.stock.sale;

import eleven.modules.TestModuleFarm3.farm.stock.count.farm.stock.count.HowMany;

public class SellThem {
    public static void main(String[] args) {
        HowMany hm = new HowMany();
        System.out.println(hm.getCount());
    }
}
//javac -d out -m farm.stock.count,farm.stock.sale --module-source-path .\src\eleven\modules\TestModuleFarm3\

//java -p out -m farm.stock.sale/eleven.modules.TestModuleFarm3.farm.stock.sale.farm.stock.sale.SellThem

//jar -cvf mods/farm.stock.sale.jar -C out/farm.stock.sale/ .
//jar -cvf mods/farm.stock.count.jar -C out/farm.stock.count/ .

//java -p mods -m farm.stock.sale/eleven.modules.TestModuleFarm3.farm.stock.sale.farm.stock.sale.SellThem