package de.pixelgerecht.kata

enum class TestData(val asScan: String,
                    val asString: String,
                    val checksum: Int,
                    val isValid: Boolean,
                    val isIllegal : Boolean) {

    D000000000(" _  _  _  _  _  _  _  _  _ \n" +
            "| || || || || || || || || |\n" +
            "|_||_||_||_||_||_||_||_||_|\n" +
            "                           ",
            "000000000", 0,true, false),
    D111111111("                           \n" +
            "  |  |  |  |  |  |  |  |  |\n" +
            "  |  |  |  |  |  |  |  |  |\n" +
            "                           ",
            "111111111", 1,false, false),
    D222222222(" _  _  _  _  _  _  _  _  _ \n" +
            " _| _| _| _| _| _| _| _| _|\n" +
            "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
            "                           ",
            "222222222", 2,false, false),
    D333333333(" _  _  _  _  _  _  _  _  _ \n" +
            " _| _| _| _| _| _| _| _| _|\n" +
            " _| _| _| _| _| _| _| _| _|\n" +
            "                           ",
            "333333333", 3,false, false),
    D444444444("                           \n" +
            "|_||_||_||_||_||_||_||_||_|\n" +
            "  |  |  |  |  |  |  |  |  |\n" +
            "                           ",
            "444444444", 4,false, false),
    D555555555(" _  _  _  _  _  _  _  _  _ \n" +
            "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
            " _| _| _| _| _| _| _| _| _|\n" +
            "                           ",
            "555555555", 5,false, false),
    D666666666(" _  _  _  _  _  _  _  _  _ \n" +
            "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
            "|_||_||_||_||_||_||_||_||_|\n" +
            "                           ",
            "666666666", 6,false, false),
    D777777777(" _  _  _  _  _  _  _  _  _ \n" +
            "  |  |  |  |  |  |  |  |  |\n" +
            "  |  |  |  |  |  |  |  |  |\n" +
            "                           ",
            "777777777", 7,false, false),
    D888888888(" _  _  _  _  _  _  _  _  _ \n" +
            "|_||_||_||_||_||_||_||_||_|\n" +
            "|_||_||_||_||_||_||_||_||_|\n" +
            "                           ",
            "888888888", 8,false, false),
    D999999999(" _  _  _  _  _  _  _  _  _ \n" +
            "|_||_||_||_||_||_||_||_||_|\n" +
            " _| _| _| _| _| _| _| _| _|\n" +
            "                           ",
            "999999999", 9,false, false),
    D123456789("    _  _     _  _  _  _  _ \n" +
            "  | _| _||_||_ |_   ||_||_|\n" +
            "  ||_  _|  | _||_|  ||_| _|\n" +
            "                           ",
            "123456789", 0,true, false),
    D000000051(" _  _  _  _  _  _  _  _    \n" +
            "| || || || || || || ||_   |\n" +
            "|_||_||_||_||_||_||_| _|  |\n" +
            "                           ",
            "000000051", 0,true, false),
    D49006771_("    _  _  _  _  _  _     _ \n" +
            "|_||_|| || ||_   |  |  | _ \n" +
            "  | _||_||_||_|  |  |  | _|\n" +
            "                           ",
            "49006771?", 9,false, true),
    D1234_678_("    _  _     _  _  _  _  _ \n" +
            "  | _| _||_| _ |_   ||_||_|\n" +
            "  ||_  _|  | _||_|  ||_| _ \n" +
            "                           ",
            "1234?678?", 0,false, true),
    D987654321(" _  _  _  _  _     _  _    \n" +
            "|_||_|  ||_ |_ |_| _| _|  |\n" +
            " _||_|  ||_| _|  | _||_   |\n" +
            "                           ",
            "987654321", 10,false, false),
    D897654321(" _  _  _  _  _     _  _    \n" +
            "|_||_|  ||_ |_ |_| _| _|  |\n" +
            "|_| _|  ||_| _|  | _||_   |\n" +
            "                           ",
            "897654321", 9,false, false),
    D189765432("    _  _  _  _  _     _  _ \n" +
            "  ||_||_|  ||_ |_ |_| _| _|\n" +
            "  ||_| _|  ||_| _|  | _||_ \n" +
            "                           ",
            "189765432", 6,false, false),

}