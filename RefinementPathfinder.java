import java.util.*;

public class RefinementPathfinder {

    public static class Step {
        public Item startItem;
        public RefineSetting setting;
        public Item resultItem;

        public Step(Item startItem, RefineSetting setting, Item resultItem) {
            this.startItem = startItem;
            this.setting = setting;
            this.resultItem = resultItem;
        }

        @Override
        public String toString() {
            return startItem + " --(" + setting + ")--> " + resultItem;
        }
    }

    public static List<Step> findPath(Item start, Item target) {
        // Queue for BFS: each element is a path of steps
        Queue<List<Step>> queue = new LinkedList<>();
        Set<Item> visited = new HashSet<>();

        // Initialize the queue with the starting item
        queue.add(new ArrayList<>(List.of(new Step(start, null, start))));
        visited.add(start);

        while (!queue.isEmpty()) {
            // Get the current path
            List<Step> path = queue.poll();
            Step lastStep = path.get(path.size() - 1);
            Item currentItem = lastStep.resultItem;

            // Check if we reached the target
            if (currentItem.equals(target)) {
                return path;
            }

            // Explore all refinements for the current item
            for (RefineSetting setting : RefineSetting.getSettings()) {
                Output output = OutputMap.getOutputItems(Output.getFormula(currentItem, setting));
                if (output != null) {
                    for (OutputItem result : output.getPossibleOutputs()) {
                        Item nextItem = result;
                        if (!visited.contains(nextItem)) {
                            visited.add(nextItem);

                            // Create a new path by appending this step
                            List<Step> newPath = new ArrayList<>(path);
                            newPath.add(new Step(currentItem, setting, nextItem));

                            // Add the new path to the queue
                            queue.add(newPath);
                        }
                    }
                }
            }
        }

        // No path found
        return null;
    }

    public static void main(String[] args) {
        Item start = Item.KEYCARD_JANITOR;
        Item target = Item.KEYCARD_O5;

        List<Step> path = findPath(start, target);

        if (path != null) {
            System.out.println("Path found:");
            for (Step step : path) {
                System.out.println(step);
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
