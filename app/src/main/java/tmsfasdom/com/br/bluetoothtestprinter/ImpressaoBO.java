package tmsfasdom.com.br.bluetoothtestprinter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;



public class ImpressaoBO {
    private static String logoSSP = new String("^XA^MNN^JUS^FO20,20^GFA,6345,6345,27,"
            + "000000000000000000000000000000000000000000000000000000\r\n"
            + "000000000000000000000000002000000000000000000000000000\r\n"
            + "000000000000000000000000003000000000000000000000000000\r\n"
            + "000000000000000000000000007000000000000000000000000000\r\n"
            + "000000000000000000000000007800000000000000000000000000\r\n"
            + "00000000000000000000000000A800000000000000000000000000\r\n"
            + "00000000000000000000000000A400000000000000000000000000\r\n"
            + "000000000000000000000000012400000000000000000000000000\r\n"
            + "000000000000000000000000012400000000000000000000000000\r\n"
            + "000000000000000000000000002200000000000000000000000000\r\n"
            + "000000000000000000000000022200000000000000000000000000\r\n"
            + "000000000000000000000000022100000000000000000000000000\r\n"
            + "000000000000000000000000042100000000000000000000000000\r\n"
            + "000000000000000000000000042080000000000000000000000000\r\n"
            + "000000000000000000000000082080000000000000000000000000\r\n"
            + "000000000000000000000000082040000000000000000000000000\r\n"
            + "000000000000000000000000002040000000000000000000000000\r\n"
            + "000000000000000000000000102040000000000000000000000000\r\n"
            + "000000000000000000000000002020000000000000000000000000\r\n"
            + "000000000000000000000000202020000000000000000000000000\r\n"
            + "000000000000000000000000202010000000000000000000000000\r\n"
            + "000000000000000000000000402010000000000000000000000000\r\n"
            + "000000000000000000000000402008000000000000000000000000\r\n"
            + "0000000000000000000000FFC0200FF80000000000000000000000\r\n"
            + "0000000000000000000FF80020201000FFC0000000000000000000\r\n"
            + "000000000000000000780000202020000078000000000000000000\r\n"
            + "0000000000000000003E00001020600001E0000000000000000000\r\n"
            + "00000000000000000009C000082040000E40000000000000000000\r\n"
            + "0000000000000000000438000C2080007080000000000000000000\r\n"
            + "000000000000000000020700042100078300000000000000000000\r\n"
            + "0000000000000000000100E00223003C0600000000000000000000\r\n"
            + "00000000000000000000801C012201C00C00000000000000000000\r\n"
            + "000000000000000000006003C1240E001000000000000000000000\r\n"
            + "00000000000000000000300078A870002000000000000000000000\r\n"
            + "000000000000000000000800077B80004000000000000000000000\r\n"
            + "00000000000000000000040000FC00008000000000000000000000\r\n"
            + "00000000000000000000020001FC00030000000000000000000000\r\n"
            + "0000000000000000003001000E7F80060018000000000000000000\r\n"
            + "0000000000000000007000807078780C001C000000000000000000\r\n"
            + "000000000000000001F0006380AC0F10000F000000000000000000\r\n"
            + "000000000000000003E0003C01A401E0000F800000000000000000\r\n"
            + "000000000000000007E0001001220020000FC00000000000000000\r\n"
            + "00000000000000000FE0000002210020000FE00000000000000000\r\n"
            + "00000000000000001FE0000004218020000FF00000000000000000\r\n"
            + "00000000000000001FC020200C2080200807F00000000000000000\r\n"
            + "00000000000000003FCFF820082040103FE7F80000000000000000\r\n"
            + "00000000000000003FFFF820102020103FFFF80000000000000000\r\n"
            + "00000000000000007FFFF000202030101FFFFC0000000000000000\r\n"
            + "00000000000000007FFFF000202010101FFFFC0000000000000000\r\n"
            + "00000000000003007FFFE040402008100FFFFC0180000000000000\r\n"
            + "00000000000007007FFFC04080200C0807FFFC01C0000000000000\r\n"
            + "0000000000000F007FFF00418020040801FFFC01E0000000000000\r\n"
            + "0000000000001F007FFF00010030020801FFFC01F0000000000000\r\n"
            + "0000000000003F0E7FFFF08200C801081FFFFCE1F8000000000000\r\n"
            + "0000000000007F1F7FFFFC84030601847FFFFCF1FC000000000000\r\n"
            + "0000000000007F1FFFFFF88C040180843FFFFFF1FC000000000000\r\n"
            + "000000000000FF0FFFFFE008180040440FFFFFE1FE000000000000\r\n"
            + "000000000001FF0FF7FFC0106000302407FFFFE1FF000000000000\r\n"
            + "000000000001FF0FE3FE012080000C3400FF8FE1FF000000000000\r\n"
            + "000000000003FF0F0000012300000212000000E1FF800000000000\r\n"
            + "000000000003FE3E0000014C0000008A000000F8FFC00000000000\r\n"
            + "000000000007FE781F000090000000660001E03CFFC00000000000\r\n"
            + "000000000007FE78FE0003E0000000160000FE3CFFC00000000000\r\n"
            + "000000000007FEF3FE000380000000060000FF9E7FE00000000000\r\n"
            + "00000000000FFF8FFE000200000000030000FFE3FFE00000000000\r\n"
            + "00000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE00000000000\r\n"
            + "00000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE00000000000\r\n"
            + "00000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE00000000000\r\n"
            + "00000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE00000000000\r\n"
            + "00000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE00000000000\r\n"
            + "000000001007FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE01000000000\r\n"
            + "000000003807FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC03800000000\r\n"
            + "000000007807FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC03C00000000\r\n"
            + "000000007C07FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC07C00000000\r\n"
            + "00000000FC3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF87E00000000\r\n"
            + "00000000FC3FFFFFFC003FFFFFFFFFFFFFFFFFFFFFF87E00000000\r\n"
            + "00000001FE3FFFFFF00007FFFFFFFFFFFFFFFFFFFFF8FF00000000\r\n"
            + "00000001FE3FFFFFC0000183FFD7FFC00000FFFFFFF8FF00000000\r\n"
            + "00000003FE07FFFF80000003FF93FFC000001FFFFFC0FF80000000\r\n"
            + "00000007FE07FFFF001E0003FF11FFC0000007FFFFC0FFC0000000\r\n"
            + "00000007FF07FFFF00FFC003FF10FFE0000001FFFFC1FFC0000000\r\n"
            + "00000007FF06FFFE01FFF003FE10FFF00FF800FFFEC1FFC0000000\r\n"
            + "0000000FFF0EFFFE03FFF803FE10FFF00FFF007FFEE1FFE0000000\r\n"
            + "0000000FFF0CFFFE07FFFC03FC10FFF00FFF807FFE61FFE0000000\r\n"
            + "0000000FFF0CFFFE07FFFE03FC107FF00FFFC03FFE71FFE0000000\r\n"
            + "0000000FFF1CFFFC07FFFF03FC107FF00FFFE01FFE71FFF0000000\r\n"
            + "0000001FFF18FFFC07FFFF83FC107FF00FFFE01FFE31FFF0000000\r\n"
            + "0000001FFF38FFFC03FFFFC3FC107FF00FFFF01FFE39FFF0000000\r\n"
            + "0000001FFF38FFFE03FFFFC3FC107FF00FFFF00FFE19FFF0000000\r\n"
            + "0000003FFF31FFFE01FFFFE7FC107FF00FFFF00FFF19FFF8000000\r\n"
            + "0000003FFF73FFFE007FFFFFFC107FF00FFFF00FFF9DFFF8000000\r\n"
            + "0000003FFF63FFFF003FFFFFFC107FF00FFFF00FFF8DFFF8000000\r\n"
            + "0000003FFE67FFFF001FFFFFFC107FF00FFFF00FFFCCFFF8000000\r\n"
            + "0000003FFEE7FFFF8007FFFFFC107FF00FFFF00FFFCEFFF8000000\r\n"
            + "0000001FFECFFFFFC001FFFFFC107FF00FFFF00FFFE6FFF8000000\r\n"
            + "0000001FFECFFFFFE0007FFFFC107FF00FFFF00FFFE6FFF0000000\r\n"
            + "0000001FFFDFFFFFF0001FFFFC107FF00FFFF01FFFF7FFF0000000\r\n"
            + "0000001FFF9FFFFFF8000FFFFC107FF00FFFE01FFFF3FFF0000000\r\n"
            + "0000000FFFBFFFFFFC0003FFFC107FF00FFFE01FFFFBFFE0000000\r\n"
            + "0000000FFFBFFFFFFF0000FFFC107FF00FFFE03FFFFBFFE0000000\r\n"
            + "00000007FFFFFFFFFFC0007FFC107FF00FFFC03FFFFFFFC0000000\r\n"
            + "00000007FFFFFFFFFFF0001FFC107FF00FFF807FFFFFFFC0000000\r\n"
            + "00000203FFFFFFFFFFFC000FFC107FF00FFE00FFFFFFFF80800000\r\n"
            + "00000781F7FFFFFFFFFF0007FC107FF0000001FFFFFFDF03C00000\r\n"
            + "00000FC1FEFFFFFFFFFFC007FC107FF0000003FFFFFEFF07E00000\r\n"
            + "00000FC0FFFFFFFFFFFFE003FC107FF000000FFFFFFFFE07E00000\r\n"
            + "00001FE0FFFFFFFFFFFFF003FC107FF000003FFFFFFFFE0FF00000\r\n"
            + "00001FF0FFFCFFFFFFFFFC01FC107FF00FFFFFFFFE7FFE1FF00000\r\n"
            + "00001FF0FFE1FFFFFFFFFE01FC107FF00FFFFFFFFF0FFE1FF00000\r\n"
            + "00001FF8FFC3FFFFFFFFFE01FC107FF00FFFFFFFFF87FE3FF00000\r\n"
            + "00001FF81FC7FFFFFFFFFF01FC107FF00FFFFFFFFFC7F03FF80000\r\n"
            + "00003FFC1F8FFFFFFFFFFF01FC107FF00FFFFFFFFFE3F07FF80000\r\n"
            + "00001FFC181FFFFC7FFFFF81FC107FF00FFFFFFFFFF0307FF80000\r\n"
            + "00003FFC183FFFFC3FFFFF81FC107FF00FFFFFFFFFF8307FF80000\r\n"
            + "00003FFE183FFFFC1FFFFF81FC107FF00FFFFFFFFFF830FFF80000\r\n"
            + "00003FFE187FFFFC0FFFFF81FC107FF00FFFFFFFFFFC30FFF80000\r\n"
            + "00003FFE18FFFFFC07FFFF83FC107FF00FFFFFFFFFFE30FFF80000\r\n"
            + "00001FFF18FFFFFC03FFFF83FC107FF00FFFFFFFFFFE39FFF80000\r\n"
            + "00001FFF39FFFFFC01FFFF07FC107FF00FFFFFFFFFFF39FFF80000\r\n"
            + "00001FFF39FFFFFC007FFF07FC107FF00FFFFFFFFFFF19FFF80000\r\n"
            + "00001FFF33FFFFFC003FFE0FFC107FF00FFFFFFFFFFF99FFF80000\r\n"
            + "00001FFF33FFFFFC0007F81FFC107FF00FFFFFFFFFFF99FFF00000\r\n"
            + "00001FFF37FFFFFC0000003FFC107FE003FFFFFFFFFFD9FFF00000\r\n"
            + "00001FFF37FFFFFC0E00007FFC107FC001FFFFFFFFFFD9FFF00000\r\n"
            + "00001FFF37FFFFFC3FE001FFFC107FC001FFFFFFFFFFD9FFF00000\r\n"
            + "00000FFF3FFFFFFC7FFC07FFFC107FC001FFFFFFFFFFFDFFE00000\r\n"
            + "00000FFFFFFFFFFFFFFFFFFFFC107FFFFFFFFFFFFFFFFFFFE00000\r\n"
            + "000007FFFFFFFFFFFFFFFFFFFC107FFFFFFFFFFFFFFFFFFFC00000\r\n"
            + "000003FFFFFFFFFFFFFFFFFFFC107FFFFFFFFFFFFFFFFFFF800000\r\n"
            + "000003FFFFFEFFFFFFFFFFFFFC107FFFFFFFFFFFFEFFFFFF800000\r\n"
            + "000001FFFFFCFFDFFFFFFFFFFC107FFFFFFFFFF7FE7FFFFF000000\r\n"
            + "000000FFFFF8FFAFFFFFFFFFFC107FFFFFFFFFEBFE3FFFFE000000\r\n"
            + "0000003FFFE0FFA7FFFFFFFFFC107FFFFFFFFFCBFE0FFFFC000000\r\n"
            + "0000001FFF80FF87DFFFFFFFFC107FFFFFFFF7CBFE03FFF0000000\r\n"
            + "0000000FFC03FF839FFFFFFFFC107FFFFFFFF383FE807FE0000000\r\n"
            + "0000C007FC07FF838FFFFFFFFC107FFFFFFFE183FFC07FC0070000\r\n"
            + "0001E003FC0FFF910FFFFFFFFC107FFFFFFFE193FFE07F800F0000\r\n"
            + "0001F803FC1FF9910FFFFFFFFC107FFFFFFFE0133FF07F803F0000\r\n"
            + "0001FC0FF03FF8920FFFFFFFFC107FFFFFFFE4923FF81FE07F0000\r\n"
            + "0001FE0FFC3FFA224FFFFFFFFC107FFFFFFFE088BFF87FE0FF0000\r\n"
            + "0001FF8FFE7FF9124FFFFFFFFC107FFFFFFFE0113FFCFFE3FF0000\r\n"
            + "0001FFCF7E7FFC080FFFFFFFFC107FFFFFFFF0203FFCFDE7FF0000\r\n"
            + "0001FFC07EFFFC8C1FFFFFFFFC107FFFFFFFF0627FFEFC07FF0000\r\n"
            + "0000FFF070FFFC441FFFFFFFFC107FFFFFFFF0447FFE1C0FFE0000\r\n"
            + "0000FFF070FFFE003FFFFFFFFC107FFFFFFFFA00FFFE1C1FFE0000\r\n"
            + "0000FFF831FFFE203FFFFFFFFC107FFFFFFFF808FFFF1C3FFE0000\r\n"
            + "0000FFFC31FFFF107FFFFFFFFC107FFFFFFFFC01FFFF187FFE0000\r\n"
            + "0000FFFC31FFFF809FFFFFFFFC107FFFFFFFFA93FFFF187FFE0000\r\n"
            + "0000FFFE31FFFCC91FFFFFFFFC107FFFFFFFF1267FFF98FFFE0000\r\n"
            + "00007FFF31FFFC215FFFFFFFFC107FFFFFFFF1087FFF99FFFE0000\r\n"
            + "00007FFF39FFFC145FFFFFFFFC107FFFFFFFF0507FFF99FFFC0000\r\n"
            + "00007FFFBBFFFE0A13FFFFFFFC107FFFFFFF90A07FFFBBFFFC0000\r\n"
            + "00007FFF9BFFFE4411FFFFFFFC107FFFFFFF1084FFFFB3FFFC0000\r\n"
            + "00003FFFDBFFFE2601FFFFFFFC107FFFFFFF0048FFFFB3FFF80000\r\n"
            + "00003FFFDBFFFF0221FFFFFFFC107FFFFFFF0A01FFFFB7FFF80000\r\n"
            + "00003FFFFFFFFF0020FFFFFFFC107FFFFFFE0811FFFFFFFFF80000\r\n"
            + "00001FFFFFFFFC6000FF9FFFFC107FFFF3FE000C7FFFFFFFF00000\r\n"
            + "00001FFFFFFFFC1800FF5FFFFC107FFFF5FE04307FFFFFFFF00000\r\n"
            + "00000FFFFFFEFC4600FF4FFFFC107FFFF5FE04C07EFFFFFFE00000\r\n"
            + "00000FFFFFFEFE2340FE4FFFFC107FFFE4FE0588FEFFFFFFE00000\r\n"
            + "000007FFFFFCFF1080764FFFFC107FFFE4DE0610FE7FFFFFC00000\r\n"
            + "000003FFFFF07F08406A4FFFFC107FFFE4AE0421FE1FFFFFC00000\r\n"
            + "000003FFFFE07FC040EA4FFFFC107FFFE4AE0447FC0FFFFF800000\r\n"
            + "000000FFFFC07E1820E94BFFFC107FFFA52E0030FC07FFFE000000\r\n"
            + "0000007FFF807E06A0E147FFFC107FFFD52608C0FC03FFFC000000\r\n"
            + "0000003FFFC07F01E0C055FFFC107FFF54060F01FC07FFF8000000\r\n"
            + "00007C0FFFC0FF1060C0C2F3FC107F9E82070C11FE07FFE0000000\r\n"
            + "0000FFE3FFC0FF8831C0EA69FC107F2CAE071823FE07FFCFFC0000\r\n"
            + "0001FFFE7FC0FF821BC46A68FC107E2CAC47B083FE07FFFFFE0000\r\n"
            + "0003FFFF9FE0FFC10BC44A2FFFFFFFE8A447A107FE0FFFFFFF0000\r\n"
            + "0007FFFFFFE0FFE087C44A2800000028A447C20FFE0FFFFFFF0000\r\n"
            + "000FEFFFFFE0FFF043E4482800000028244F841FFE0FFFFF9F8000\r\n"
            + "000FE0FFFF80FFFC03E0490800000820240F883FFE07FFFF0FC000\r\n"
            + "001FE07FFF80FFE0C0384908000008212478060FFE0FFFFF07C000\r\n"
            + "003FC03FFFC0FFF41F866928000000292CC3F07FFE3FFF1E07E000\r\n"
            + "007FC639FFF07FF20641E028000000280F04C09FFC7FFF1E23F000\r\n"
            + "007FC030FFF87FF8832064A6FF7DFFEA4C08823FFDFFF30E23F800\r\n"
            + "00FF80703FFC7FFC210814A21E01F08A5021083FFFFFC38E01F800\r\n"
            + "01FF8FE11FFE7FFE3C8408021FC3F080204278FFFFFFC18601FC00\r\n"
            + "03FF8FE18FFFFFFF80C106511F87F014C10603FFFFFEC08470FE00\r\n"
            + "03FFCFC00FFFFFFF202083411F1CF114820809FFFFF860C47FFE00\r\n"
            + "07FFFFC41CFFFFFF8C1023291E31F129881063FFFFF82443FFFF00\r\n"
            + "0FFFFF84303FFFFFC10010A89F61F22A100107FFFFF80227FFFF80\r\n"
            + "0FFFFFCC601FFFFFF063FFC49F85F247FF8C1FFFFFDC023FFFFF80\r\n"
            + "1FFFFFFC610FFFF7F81800264F0DE4C800303FDFFF8E01FFFFFFC0\r\n"
            + "1FFFFFFC438FFFE3FE20000A4F19E4800008FF8FFF8621FFFFFFE0\r\n"
            + "3FFFFFFF478FFFE1FF9600072F61E1C000D3FF0FFCC31FFFFFFFE0\r\n"
            + "7FFFFFFFC70FFFC0FFF83FF88F43E23FF83FFE1FF8E11FFFFFFFF0\r\n"
            + "7FFFFFFFE01FFFE07FFE0001C18F070000FFFC3FF8F0BFFFFFFFF8\r\n"
            + "7FFFFFFFE01FFFF03FF8803861180C38033FF87FEC70FFFFFFFFF8\r\n"
            + "FFFFFFFFF83FFFF83FF3FE00FC31FF00FF9FF8FFC038FFFFFFFFFC\r\n"
            + "FFFFFFFFFFFFFFFC3FFC000FC0C307E0007FF9FF8003FFFFFFFFFC\r\n"
            + "7FFFFFFFFFFBFFFE1FFF007E0787E0FC01FFF3FF7007FFFFFFFFFC\r\n"
            + "7FFFFFFFFFF1FFFF1FFFFFF03F19F81FFFFFFFFC3C4FFFFFFFFFF8\r\n"
            + "3FFFFFFFFFF8FDFFDFFFFFC1FF31FF07FFFFFFF85C7FFFFFFFFFF8\r\n"
            + "1FFFFFFFFFFCF8FFFFFFFF07FF61FFC1FFFFFFF08C7FFFFFFFFFE0\r\n"
            + "07FFFFFFFFFFF07FFFFFFC1FFF85FFF07FFFFFE11C7FFFFFFFFFC0\r\n"
            + "01FFFFFFFFFFE03FFFFFFCFFFF0FFFFE7FFFFFE030FFFFFFFFFF00\r\n"
            + "03FFFFFFFFFFC11FFFFFFFFFFF01FFFFFFFFFFF061FFFFFFFFFF00\r\n"
            + "07FFFFFFFFFFC00FFFFFFFFFFF03FFFFFFFFFFF807FFFFFFFFFF80\r\n"
            + "0FFFFFFFFFFF8013FFFFFFFFFF87FFFFFFFFFFFC0FFFFFFFFFFFC0\r\n"
            + "1FFFFFFFFFFF8411FFFFCFFFFFFFFFFFC7FFFFFE1FFFFFFFFFFFC0\r\n"
            + "1FFFFFFFFFFFC0607FFF81FFFFFFFFFF03FFFFFF3FFFFFFFFFFFE0\r\n"
            + "3FFFFFFFFFFFE0403FFF803FFFFFFFF803FFFFCFFFFFFFFFFFFFF0\r\n"
            + "3FFFFFFFFFF7F8863FFF8003FFFFFF8003FF8F8FFF3FFFFFFFFFF0\r\n"
            + "7F007FFFFFF3FF001FFFE0000FFFC0000FFF0F1FFE3FFFFFFFFFF8\r\n"
            + "400003FFFFF1FF0039FFFC00000000007FFC1FBFFC1FFFFFC00000\r\n"
            + "0000007FFFE3FF1070FFFF0000000001FFF81FFFFF9FFFFC000000\r\n"
            + "0000001FFFFFFFB1E07FFFF00000001FFFE01FFFFFFFFFE0000000\r\n"
            + "00000003FFFFFFF1C0FFFFFF800001FFFFC30FFFFFFFFF80000000\r\n"
            + "00000000FFFFFFF100C3FFFFFFFFFFFFFDC787FFFFFFF800000000\r\n"
            + "000000003FFFFFF808C0FFFFFFFFFFFFF06387FFFFFFF000000000\r\n"
            + "000000007FFFFFFE00844FFFFFFFFFFFB823C3FFFFFFFC00000000\r\n"
            + "00000001FFFFFFFF60C401FFFFFFFFFE1801EFFFFFFFFF00000000\r\n"
            + "00000000FFFFFFFFF04108FFFFFFFF8E0C01FFFFFFFFFF00000000\r\n"
            + "000000007FFFFFFFF11188F1C7FFC0060440FFFFFFFFFE00000000\r\n"
            + "000000003FFFFFFFF91800F1C3FFC0064431FFFFFFFFF800000000\r\n"
            + "000000000FFFFFFFFF0011F183FFC7C6423FFFFFFFFFE000000000\r\n"
            + "0000000003FFFFFFFF8111E183FFC046001FFFFFFFFF8000000000\r\n"
            + "00000000007FFFFFFFE211E111FFC044007FFFFFFFFE0000000000\r\n"
            + "00000000001FFFFFFFFE20E311E1E1C03BFFFFFFFFF80000000000\r\n"
            + "000000000003FFFFBFFFE02201E1E3E07FFFF3FFFF800000000000\r\n"
            + "0000000000000FFC0FFFF80201E1E3E0FFFFC07FF0000000000000\r\n"
            + "000000000000000003FFFFA030FFE3FFFFFF000000000000000000\r\n"
            + "000000000000000001FFFFFFF8FFFFFFFFFC000000000000000000\r\n"
            + "0000000000000000007FFFFFFFFFFFFFFFF0000000000000000000\r\n"
            + "0000000000000000003FFFFFFFFFFFFFFFFC000000000000000000\r\n"
            + "000000000000000003FFFFFFFFFFFFFFFFFF800000000000000000\r\n"
            + "00000000000000001FFFFFFFFFFFFFFFF3FFF00000000000000000\r\n"
            + "0000000000000001FFFC0FFFFFFFFFFF807FFF0000000000000000\r\n"
            + "0000000000000007FFE000FFFFFFFFF0000FFFE000000000000000\r\n"
            + "000000000000000FFF000001FFFFFC000001FFE000000000000000\r\n"
            + "000000000000001FF80000000000000000001FF000000000000000\r\n"
            + "000000000000001F8000000000000000000003F000000000000000\r\n"
            + "000000000000001800000000000000000000003000000000000000\r\n"
            + "\r\n^FO235,70^A0,N,25,24^FDSECRETARIA DE ESTADO DOS NEGOCIOS DA SEGURANCA PUBLICA"
            + "\r\n^FO235, 120^A0,N,25,24^FDPOLICIA MILITAR DO ESTADO DE SAO PAULO"
            + "\r\n^FO235, 170^A0,N,25,24^FDTERMO CIRCUNSTANCIADO DE OCORRENCIA");


    public static byte[] obterTermoCompromisso(String ocrnum, String ocrdat, String autor, String autoridadePM, String nomeMunicipio, String enderecoForum, String dataMarcada) {
        String retorno = null;
        StringBuilder messageString1 = new StringBuilder();
        messageString1.append(logoSSP);
        messageString1.append("\r\n^FO235, 220^A0,N,25,24^FDOCORRENCIA NR:").append(ocrnum).append(" - DATA: ").append(ocrdat);
        messageString1.append("\r\n^FO150, 350^A0,N,50,40^FDTERMO DE COMPROMISSO DO AUTOR");
        messageString1.append("\r\n^FO20,480^FB795,50,1,J,1^A0,N,35,30^FDComprometo-me a comparecer no local indicado, " +
                "\r\na fim de participar de audiencia preliminar sobre fato constante do Termo Circunstanciado, " +
                "\r\nacima descrito. Estou ciente de que a concordancia em comparecer ao JECRIM acompanhado ou nao " +
                "\r\nde advogado, nao implica em confissao de qualquer natureza ou admissao de culpa. Estou ciente de " +
                "\r\nque o nao comparecimento implicara em sancoes legais. Comprometo-me ainda a comunicar, de imediato, " +
                "\r\nao respectivo Forum, qualquer mudanca de endereco. Fui notificado a comparecer no Forum da Comarca de " + 
                nomeMunicipio + ", \r\ncom endereco a " + enderecoForum + ", na Secretaria do Juizado Especial Criminal ");
        if (dataMarcada != null) {
            messageString1.append("na seguinte data: " + dataMarcada);
        } else {
            messageString1.append("quando intimado pela Secretaria do JECrim.");
        }
        messageString1.append("\r\n^FO20,920^A0,N,25,20^FDAUTOR:");
        messageString1.append("\r\n^FO160,960^A0,N,35,30^FD____________________________________________");
        messageString1.append("\r\n^FO190,1010^A0,N,35,30^FD").append(autor);
        messageString1.append("\r\n^FO20,1060^A0,N,25,20^FDAUTORIDADE PM:");
        messageString1.append("\r\n^FO160,1100^A0,N,35,30^FD____________________________________________");
        messageString1.append("\r\n^FO190,1160^A0,N,35,30^FD").append(autoridadePM);
        messageString1.append("^XZ");
        retorno = messageString1.toString();
        return retorno.getBytes(Charset.forName("UTF-8"));
    }


    public static byte[] obterTermoManifestacaoOfendido(String ocrnum,
                                                        String ocrdat,
                                                        String nomeOfendido,
                                                        String autoridadePM,
                                                        String nomeMunicipio,
                                                        String tipoManifestacao,
                                                        String enderecoForum,
                                                        String dataMarcada
                                                        ) {
        String retorno = null;
        StringBuilder messageString1 = new StringBuilder();
        messageString1.append(logoSSP);
        messageString1.append("^FO235, 220^A0,N,25,24^FDOCORRENCIA NR:").append(ocrnum).append(" - DATA: ").append(ocrdat);
        messageString1.append("^FO140, 350^A0,N,50,40^FDTERMO DE MANIFESTACAO DO OFENDIDO");
        messageString1.append("^FO20,480^FB795,50,1,J,1^A0,N,35,30^FDEu, " + nomeOfendido + ", por este instrumento, manifesto o meu interesse " + tipoManifestacao + ". Fui notificado a comparecer no Forum da Comarca de " + nomeMunicipio + ", com endereco a " + enderecoForum + ", na Secretaria do Juizado Especial Criminal ");
        if (dataMarcada != null) {
            messageString1.append("na seguinte data: " + dataMarcada);
        } else {
            messageString1.append("quando intimado pela Secretaria do JECrim.");
        }
        messageString1.append("^FO20,740^A0,N,25,20^FDOFENDIDO:");
        messageString1.append("^FO160,790^A0,N,35,30^FD____________________________________________");
        messageString1.append("^FO190,840^A0,N,35,30^FD").append(nomeOfendido);
        messageString1.append("^FO20,890^A0,N,25,20^FDAUTORIDADE PM:");
        messageString1.append("^FO160,940^A0,N,35,30^FD____________________________________________");
        messageString1.append("^FO190,990^A0,N,35,30^FD").append(autoridadePM);
        messageString1.append("^XZ");
        retorno = messageString1.toString();
        return retorno.getBytes();
    }

    public static byte[] obterTermoManifestacaoOfendido(String ocrnum,
                                                        String ocrdat,
                                                        String nomeOfendido,
                                                        String autoridadePM,
                                                        String tipoManifestacao) {
        String retorno = null;
        StringBuilder messageString1 = new StringBuilder();
        messageString1.append(logoSSP);
        messageString1.append("^FO235, 220^A0,N,25,24^FDOCORRENCIA NR:").append(ocrnum).append(" - DATA: ").append(ocrdat);
        messageString1.append("^FO140, 350^A0,N,50,40^FDTERMO DE MANIFESTACAO DO OFENDIDO");
        messageString1.append("^FO20,480^FB795,50,1,J,1^A0,N,35,30^FDEu, " + nomeOfendido + ", por este instrumento, manifesto o meu interesse " + tipoManifestacao + ".");
        messageString1.append("^FO20,680^A0,N,25,20^FDOFENDIDO:");
        messageString1.append("^FO160,730^A0,N,35,30^FD____________________________________________");
        messageString1.append("^FO190,780^A0,N,35,30^FD").append(nomeOfendido);
        messageString1.append("^FO20,830^A0,N,25,20^FDAUTORIDADE PM:");
        messageString1.append("^FO160,880^A0,N,35,30^FD____________________________________________");
        messageString1.append("^FO190,930^A0,N,35,30^FD").append(autoridadePM);
        messageString1.append("^XZ");
        retorno = messageString1.toString();
        return retorno.getBytes();
    }

    public static byte[] obterRequisicaoPericialLesao(String ocrnum,
                                                      String ocrdat,
                                                      String nomeOfendido,
                                                      String autoridadePM,
                                                      String opm,
                                                      String enderecoOpm,
                                                      String historico,
                                                      String[] quesitos) {
        //#setagem das variaveis para teste
        ocrnum = "2017042300214";
        ocrdat = "23/04/2017 18:00:00";
        nomeOfendido = "FERNANDO ANDRADE DOS SANTOS - RG 44308344 SSP/SP";
        autoridadePM = "DANILO MARCELO CALLEGARI - RG 33555444 SSP/SP";
        opm = "1 CIA do 12 BPM/M";
        enderecoOpm = "Rua Rafael Iorio, 100, Campo Belo - Sao Paulo/SP - CEP 01122-000";
        historico = "Trata-se de ocorrencia de acidente de transito com vitima ocorrido na Av Washington Luis, defronte ao Aeroporto de Congonhas.";
        quesitos = new String[]{
                "Há ofensa à integridade corporal ou à saúde do(a) periciando(a)?",
                "Qual o instrumento ou meio que a produziu?",
                "A  ofensa  foi  produzida  com  o  emprego  de  veneno,  fogo,  explosivo, tortura  ou  outro  meio  insidioso  ou  cruel,  ou  de  que  podia  resultar perigo comum? (resposta especificada)",
                "Resultou perigo de vida?",
                "Resultou  incapacidade  para  as  ocupações  habituais,  por  mais  de  30 (trinta) dias?",
                "Resultou  debilidade  permanente  de  membro,  sentido  ou  função,  ou aceleração de parto? (resposta especificada)",
                "Resultou  incapacidade  permanente  para  o  trabalho,  ou  enfermidade incurável, ou perda ou inutilização de membro, sentido ou função, ou deformidade permanente, ou aborto? (resposta especificada)"
        };
        //#fim da setagem
        String retorno = null;
        StringBuilder messageString1 = new StringBuilder();
        messageString1.append(logoSSP);
        messageString1.append("^FO235, 220^A0,N,25,24^FDOCORRENCIA NR:").append(ocrnum).append(" - DATA: ").append(ocrdat);
        messageString1.append("^FO235, 270^A0,N,25,24^FD").append(opm);
        messageString1.append("^FO235, 300^FB795,50,1,J,1^A0,N,25,24^FD").append(enderecoOpm);

        messageString1.append("^FO140, 350^A0,N,50,40^FDREQUISICAO DE EXAME DE CORPO DELITO");
        messageString1.append("^FO20,430^A0,N,35,30^FDDA: Equipe Policial Militar da ").append(opm);
        messageString1.append("^FO20,450^A0,N,35,30^FDAO: Diretor do IML.");

        messageString1.append("^FO20,480^FB795,50,1,J,1^A0,N,35,30^FDSolicitamos a V.Sa., determinar a realizacao do exame de Corpo de Delito - Lesao Corporal, na forma do artigo 158 e seguintes do Codigo de Processo Penal, na pessoa de " + nomeOfendido + ", tendo em vista apurar o seguinte relato:");
        messageString1.append("^FO20,540^FB795,50,1,J,1^A0,N,35,30^FD").append(historico);

        messageString1.append("^FO20,680^A0,N,35,30^FDQuesitacao:");

        int posicaoY = 720;
        for (String quesito : quesitos) {
            messageString1.append("^FO20," + posicaoY + "^A0,N,35,30^FD" + quesito);
            posicaoY = posicaoY + 80;
        }

        messageString1.append("^FO20," + (posicaoY + 80) + "^A0,N,25,20^FDOFENDIDO:");
        messageString1.append("^FO160," + (posicaoY + 80) + "^A0,N,35,30^FD____________________________________________");
        messageString1.append("^FO190," + (posicaoY + 80) + "^A0,N,35,30^FD").append(nomeOfendido);
        messageString1.append("^FO20," + (posicaoY + 80) + "^A0,N,25,20^FDAUTORIDADE PM:");
        messageString1.append("^FO160," + (posicaoY + 80) + "^A0,N,35,30^FD____________________________________________");
        messageString1.append("^FO190," + (posicaoY + 80) + "^A0,N,35,30^FD").append(autoridadePM);
        messageString1.append("^XZ");
        retorno = messageString1.toString();
        return retorno.getBytes();
    }

    public static byte[] obterRegua() {
        String retorno = null;
        StringBuilder messageString1 = new StringBuilder();
        messageString1.append(logoSSP);
   /*     messageString1.append("^FO10, 20^A0,N,6,6^FDY20");
        messageString1.append("^FO10, 30^A0,N,6,6^FDY30");
        messageString1.append("^FO10, 40^A0,N,6,6^FDY40");
        messageString1.append("^FO10, 50^A0,N,6,6^FDY50");
        messageString1.append("^FO10, 60^A0,N,6,6^FDY60");
        messageString1.append("^FO10, 70^A0,N,6,6^FDY70");
        messageString1.append("^FO10, 80^A0,N,6,6^FDY80");
        messageString1.append("^FO10, 90^A0,N,6,6^FDY90");
        messageString1.append("^FO10, 100^A0,N,6,6^FDY100");
        messageString1.append("^FO10, 110^A0,N,6,6^FDY110");
        messageString1.append("^FO10, 120^A0,N,6,6^FDY120");
        messageString1.append("^FO10, 130^A0,N,6,6^FDY130");
        messageString1.append("^FO10, 140^A0,N,6,6^FDY140");
        messageString1.append("^FO10, 150^A0,N,6,6^FDY150");
        messageString1.append("^FO10, 160^A0,N,6,6^FDY160");
        messageString1.append("^FO10, 170^A0,N,6,6^FDY170");
        messageString1.append("^FO10, 180^A0,N,6,6^FDY180");
        messageString1.append("^FO10, 190^A0,N,6,6^FDY190");
        messageString1.append("^FO10, 200^A0,N,6,6^FDY200");*/
        messageString1.append("^FO20, 10^A0,N,6,6^FDX20");
        messageString1.append("^FO30, 10^A0,N,6,6^FDX30");
        messageString1.append("^FO40, 10^A0,N,6,6^FDX40");
        messageString1.append("^FO50, 10^A0,N,6,6^FDX50");
        messageString1.append("^FO60, 10^A0,N,6,6^FDX60");
        messageString1.append("^FO70, 10^A0,N,6,6^FDX70");
        messageString1.append("^FO80, 10^A0,N,6,6^FDX80");
        messageString1.append("^FO90, 10^A0,N,6,6^FDX90");
        messageString1.append("^FO100, 10^A0,N,6,6^FDX100");
        messageString1.append("^FO110, 10^A0,N,6,6^FDX110");
        messageString1.append("^FO120, 10^A0,N,6,6^FDX120");
        messageString1.append("^FO130, 10^A0,N,6,6^FDX130");
        messageString1.append("^FO140, 10^A0,N,6,6^FDX140");
        messageString1.append("^FO150, 10^A0,N,6,6^FDX150");
        messageString1.append("^FO160, 10^A0,N,6,6^FDX160");
        messageString1.append("^FO170, 10^A0,N,6,6^FDX170");
        messageString1.append("^FO180, 10^A0,N,6,6^FDX180");
        messageString1.append("^FO190, 10^A0,N,6,6^FDX190");
        messageString1.append("^FO200, 10^A0,N,6,6^FDX200");

        messageString1.append("^XZ");
        retorno = messageString1.toString();
        return retorno.getBytes();
    }

}
