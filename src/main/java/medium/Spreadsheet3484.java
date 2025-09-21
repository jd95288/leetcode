package medium;


/**
 * 设计电子表格
 * <p>
 * 电子表格是一个网格，它有 26 列（从 'A' 到 'Z'）和指定数量的 rows。每个单元格可以存储一个 0 到 105 之间的整数值。
 * 请你实现一个 Spreadsheet 类：
 * Spreadsheet(int rows) 初始化一个具有 26 列（从 'A' 到 'Z'）和指定行数的电子表格。所有单元格最初的值都为 0 。
 * void setCell(String cell, int value) 设置指定单元格的值。单元格引用以 "AX" 的格式提供（例如，"A1"，"B10"），其中字母表示列（从 'A' 到 'Z'），数字表示从 1 开始的行号。
 * void resetCell(String cell) 重置指定单元格的值为 0 。
 * int getValue(String formula) 计算一个公式的值，格式为 "=X+Y"，其中 X 和 Y 要么 是单元格引用，要么非负整数，返回计算的和。
 * 注意： 如果 getValue 引用一个未通过 setCell 明确设置的单元格，则该单元格的值默认为 0 。
 *
 * @author jd95288
 * @date 2025-09-19 8:38
 */
public class Spreadsheet3484 {

    class Spreadsheet {

        private final int[][] data;

        public Spreadsheet(int rows) {
            data = new int[26][rows + 1];
        }

        public void setCell(String cell, int value) {
            int col = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1));
            data[col][row] = value;
        }

        public void resetCell(String cell) {
            int col = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1));
            data[col][row] = 0;
        }

        public int getValue(String formula) {
            String[] params = formula.substring(1).split("\\+");
            int res = 0;
            for (String param : params) {
                if (param.charAt(0) < 'A' || param.charAt(0) > 'Z') {
                    res += Integer.parseInt(param);
                } else {
                    int col = param.charAt(0) - 'A';
                    int row = Integer.parseInt(param.substring(1));
                    res += data[col][row];
                }
            }
            return res;
        }
    }

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
}
